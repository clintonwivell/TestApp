package main.com.gap;

/*
 * Describes the current day open price GapZone as it relates to the previous day
 * D = prior day was "down" (directionally from open to close)
 * U = prior day was "up"
 * H = above the prior day's high price
 * HO = below the prior high and above the prior day's open
 * OC = below the prior open and above the prior close
 * CL = below the prior close and above the prior low
 * HC = below the prior high and above the prior close
 * CO = below the prior close and above the prior open
 * OL = below the prior open and above the prior low
 * L = below the prior day's low price
 */
public enum GapZone {
	DH,DHO,DOC,DCL,DL,UH,UHC,UCO,UOL,UL,NoZONE;
}
