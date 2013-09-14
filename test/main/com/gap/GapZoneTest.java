package main.com.gap;

import static org.junit.Assert.*;

import org.junit.Test;

public class GapZoneTest {
	
	GapZoneAssigner gapZone = new GapZoneAssigner();
	
	@Test
	public void testAssignGapZone() {
		boolean gapZoneResult = gapZone.assignGapZone();
		assert(gapZoneResult);
	}

}
