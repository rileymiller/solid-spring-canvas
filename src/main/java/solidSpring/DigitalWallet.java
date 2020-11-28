package solidSpring;

public class DigitalWallet {
	
	private static DigitalWallet wallet = new DigitalWallet();
	
	private static final String NAME = "Bitcoin";
	private static final String WHITE_PAPER = "https://bitcoin.org/bitcoin.pdf";
	private double BTC = 0;
	
	private DigitalWallet() { };
	
	public static DigitalWallet getInstance()
	{
		return wallet;
	}
	
	
	public DigitalWallet processTransaction( double amount ) throws Exception
	{
		if( BTC + amount < 0 )
		{
			throw new Exception(String.format("\nInsufficient funds:\n\t BTC Available: %1$s\n\t BTC Requested: %2$s", BTC, amount));
		} else {
			BTC = BTC + amount;
		}
		
		return this;
	}
	
	public DigitalWallet zero()
	{
		BTC = 0;
		
		return this;
	}
	
	public DigitalWallet accountBalance()
	{
		return this;
	}
	
	/////////////////////////////////////////
	//	For Serialization
	////////////////////////////////////////
	public double getBTC() 
	{
		return BTC;
	}
	
	public String getName()
	{
		return NAME;
	}
	
	public String getWhitePaper()
	{
		return WHITE_PAPER;
	}
	
	public double getSatoshis()
	{
		return BTC * 100000000;
	}

}
