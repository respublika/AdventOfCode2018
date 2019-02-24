package day4;

import java.time.LocalDateTime;
import java.util.Date;

public class NightActivity {
	LocalDateTime actionTime;
	String guardId;
	Boolean sleep;
	
	public NightActivity() {}
	
	public NightActivity(LocalDateTime actionTime, String guardId, Boolean sleep) {
		this.actionTime = actionTime;
		this.guardId = guardId;
		this.sleep = sleep;
	}
	
	public NightActivity(LocalDateTime actionTime) {
		this.actionTime = actionTime;
	}

	
	public LocalDateTime getActionTime() {
		return actionTime;
	}
	
	public void setActionTime(LocalDateTime actionTime) {
		this.actionTime = actionTime;
	}
	
	public String getGuardId() {
		return guardId;
	}
	
	public void setGuardId(String guardId) {
		this.guardId = guardId;
	}
	
	public Boolean getSleep() {
		return sleep;
	}
	
	public void setSleep(Boolean sleep) {
		this.sleep = sleep;
	}

}
