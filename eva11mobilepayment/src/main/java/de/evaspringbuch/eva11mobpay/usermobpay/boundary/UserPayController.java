package de.evaspringbuch.eva11mobpay.usermobpay.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.evaspringbuch.eva11mobpay.usermobpay.domain.PayUser;
import de.evaspringbuch.eva11mobpay.usermobpay.domain.State;
import de.evaspringbuch.eva11mobpay.usermobpay.service.PayUserException;
import de.evaspringbuch.eva11mobpay.usermobpay.service.PayUserService;
import de.evaspringbuch.eva11mobpay.usermobpay.service.dto.AccountResponseDTO;
import de.evaspringbuch.eva11mobpay.usermobpay.service.dto.PayUserResponseDTO;
import de.evaspringbuch.eva11mobpay.usermobpay.service.dto.TransferDTO;

@RestController
@RequestMapping(value = "/users")

public class UserPayController {

//    private static final Logger log = LoggerFactory.getLogger(UserPayController.class);

    private PayUserService payUserService;

    @Autowired
    public UserPayController(PayUserService payUserService) {
        this.payUserService = payUserService;
    }

    @RequestMapping(value = "/{userId}") //, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listPayUser(@PathVariable String userId) {
        PayUser payUser = payUserService.getPayUser(userId);
        PayUserResponseDTO payUserResponseDTO = new PayUserResponseDTO(payUser);
//        payUserResponseDTO.add(linkTo(UserPayController.class).slash(userId).withSelfRel());
//        payUserResponseDTO.add(linkTo(methodOn(UserPayController.class).listAccountBalance(userId)).withRel("account"));
//        payUserResponseDTO.add(linkTo(methodOn(UserPayController.class).changeUserToSuspendedState(userId, "suspended")).withRel("suspend"));
        return ResponseEntity.status(HttpStatus.OK).body(payUserResponseDTO);
    }

    @RequestMapping(value = "/{userId}/account") //, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listAccountBalance(@PathVariable String userId) {
        State payUserState = payUserService.getState(userId);
        if (payUserState == State.available) {//        return new ResponseEntity<Authenticator.Success>(HttpStatus.OK);
            int balance = payUserService.getAccountBalanceByName(userId);
            return ResponseEntity.status(HttpStatus.OK).body(new AccountResponseDTO("Kontostand betraegt " + balance));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new AccountResponseDTO("transferNotAllowed"));
        }
    }

    @RequestMapping(value = "/{userId}/opened", method = RequestMethod.PUT)
    public ResponseEntity<?> openAccount(@PathVariable String userId) {
        payUserService.openAccount(userId);
        return ResponseEntity.status(HttpStatus.OK).body(new AccountResponseDTO("Konto steht nun zur Verfuegung"));
    }

    @RequestMapping(value = "/{userId}/payment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> transfer(@PathVariable String userId, @RequestBody TransferDTO input) {
        String to = input.getTo();
        int amount = input.getAmount();
        String returnStatus = null;
        try {
            returnStatus = payUserService.transfer(userId, to, amount);
        } catch (PayUserException e) {
            e.printStackTrace();
        }

        if (returnStatus.equals("okay"))
            return ResponseEntity.status(HttpStatus.CREATED).body(new AccountResponseDTO("Transfer ist erfolgreich durchgefuehrt"));
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new AccountResponseDTO(returnStatus));
    }

    @RequestMapping(value = "/{userId}/deleted", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {
        payUserService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(new AccountResponseDTO("Nutzer und Konto ist nun geloescht"));
    }

    @RequestMapping(value = "/{userId}/suspended", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> changeUserToSuspendedState(@PathVariable String userId, @RequestBody String state) {
    	if (State.valueOf(state) == State.suspended) {       	
            payUserService.changeUserToSuspendedState(userId);
            return ResponseEntity.status(HttpStatus.OK).body(new AccountResponseDTO("suspended"));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new AccountResponseDTO("Falscher Zustand eingegeben"));
    }

}
