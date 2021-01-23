import java.util.ArrayList;

/**
 * Holds the Golfer player
 * @author extre
 *
 */
public class Golfer implements Subject {
	
	private String name;
	private ArrayList<Observer> observers;
	
	/**
	 * Creates a golfer
	 * @param name
	 */
	public Golfer(String name) {
		this.name = name;
		observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
		
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
		
	}

	@Override
	public void notifyObservers(int strokes, int par) {
		for(Observer observer : observers) {
			observer.update(strokes, par);
		}
	}
	
	public void enterScore(int strokes, int par) {
		notifyObservers(strokes, par);
		
	}
	
	public String getName() {
		return this.name;
	}
	



}
