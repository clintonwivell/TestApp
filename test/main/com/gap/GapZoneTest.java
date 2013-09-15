package main.com.gap;

import static org.junit.Assert.*;

import main.com.gap.exception.NoGapZoneException;

import org.junit.Test;

public class GapZoneTest {
	
	GapZoneAssigner gapZone = new GapZoneAssigner();
	
	@Test
	public void testAssignGapZone() throws NoGapZoneException {
		boolean gapZoneResult = gapZone.assignGapZone();
		assert(gapZoneResult);
	}

}
