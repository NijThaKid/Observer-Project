 /**
  * Round's Score Display
  * @author extre
  *
  */
public class RoundScoreDisplay implements Observer{
	
	Subject golfer;
	private int strokesTotal;
	private int parTotal;
	
	/**
	 * This creates the round total and see if the golfer is on pace to be under or over par
	 * @param golfer
	 */
	public RoundScoreDisplay(Subject golfer) {
		this.golfer = golfer;
		golfer.registerObserver(this);
	}
	
	@Override
	public void update(int strokes, int par) {
		strokesTotal = strokesTotal + strokes;
		parTotal = parTotal + par;
		displayRoundScore();
	}
	
	public void displayRoundScore() {
		int temp = 0;
		System.out.println("Round Stats: ");
		System.out.println("Par: " +parTotal);
		System.out.println("Strokes: " +strokesTotal);
		
		temp = Math.abs(strokesTotal - parTotal);
		
		if(parTotal == strokesTotal ) {
			System.out.println("Made Par");
			
		} else if(parTotal > strokesTotal) {
			System.out.println(temp + " Under Par ");
		} else if(parTotal < strokesTotal) {
			System.out.println(temp + " Over Par ");
		}
	}

}
