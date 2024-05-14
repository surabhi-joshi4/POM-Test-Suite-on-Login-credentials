package Practice.Study.Base;

public class TestUtilities extends BaseTest{
	
	//static sleep
	protected void sleep(long milis)
	{
		try {
			Thread.sleep(milis);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
