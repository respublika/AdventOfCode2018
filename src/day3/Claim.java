package day3;

public class Claim {
	Integer left;
	Integer down;
	Integer toLeft;
	Integer toDown;
	
	public Claim() {
	}
	
	public Claim(Integer left, Integer down, Integer toLeft, Integer toDown) {
		this.left = left;
		this.down = down;
		this.toLeft = toLeft;
		this.toDown = toDown;
	}
	
	public Integer getLeft() {
		return left;
	}
	
	public void setLeft(Integer left) {
		this.left = left;
	}
	
	public Integer getDown() {
		return down;
	}
	
	public void setDown(Integer down) {
		this.down = down;
	}
	
	public Integer getToLeft() {
		return toLeft;
	}
	
	public void setToLeft(Integer toLeft) {
		this.toLeft = toLeft;
	}
	
	public Integer getToDown() {
		return toDown;
	}
	
	public void setToDown(Integer toDown) {
		this.toDown = toDown;
	}

}
