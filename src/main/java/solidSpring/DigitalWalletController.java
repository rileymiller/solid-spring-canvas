package solidSpring;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DigitalWalletController {

	@GetMapping("/balance")
	public DigitalWallet wallet() {		
		return DigitalWallet
				.getInstance()
				.accountBalance();
	}
	
	@GetMapping("/transaction")
	public DigitalWallet transaction(
			@RequestParam(value = "value", defaultValue = "0" )
			String value ) 
	{
		try
		{
			double parsedValue = Double.parseDouble( value );
			
			try 
			{
				return DigitalWallet
						.getInstance()
						.processTransaction( parsedValue );
			}
			catch ( Exception e )
			{
				throw new ResponseStatusException(
						HttpStatus.BAD_REQUEST, e.toString() );
			}
			
		} 
		catch ( NumberFormatException e )
		{
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, e.toString() );
		}
	}
	
	@GetMapping("/zero")
	public DigitalWallet zero()
	{
		return DigitalWallet
				.getInstance()
				.zero();
	}
}