package day4;

public class Guard {
	String id;
	Integer maxSleep;
	
	
	public Guard(String id, Integer maxSleep) {
		this.id = id;
		this.maxSleep = maxSleep;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Integer getMaxSleep() {
		return maxSleep;
	}
	
	public void setMaxSleep(Integer maxSleep) {
		this.maxSleep = maxSleep;
	}

}
