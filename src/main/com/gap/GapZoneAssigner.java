package main.com.gap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.com.gap.exception.NoGapZoneException;

public class GapZoneAssigner {
	
	public GapZoneAssigner(){
		
	}

	public boolean assignGapZone() throws NoGapZoneException {
		DOHLC currentDay;
		DOHLC previousDay;
		DohlcDAO dao = new DohlcDAO();
		List <DohlcPair> NoZONE = new ArrayList<DohlcPair>();
		
		List <DOHLC> DH = new ArrayList<DOHLC>();
		List <DOHLC> DHO = new ArrayList<DOHLC>();
		List <DOHLC> DOC = new ArrayList<DOHLC>();
		List <DOHLC> DCL = new ArrayList<DOHLC>();
		List <DOHLC> DL = new ArrayList<DOHLC>();
		
		List <DOHLC> UH = new ArrayList<DOHLC>();
		List <DOHLC> UHC = new ArrayList<DOHLC>();
		List <DOHLC> UCO = new ArrayList<DOHLC>();
		List <DOHLC> UOL = new ArrayList<DOHLC>();
		List <DOHLC> UL = new ArrayList<DOHLC>();
		
		int totalCounted = 0;
		int DownDaycounter = 0;
		int UpDaycounter = 0;
		
		System.out.println("Get DOHLC List");
		
		Iterator <DOHLC> iterator = dao.listAll().iterator();
		currentDay = (DOHLC) iterator.next();
		
		System.out.println("*****Begin Assigning Gap Zone*****");
		while(iterator.hasNext())
		{
			previousDay = (DOHLC) iterator.next();
			
			//PRIOR DAY DOWN
			if(previousDay.getOpen() >= previousDay.getClose())
			{
				DownDaycounter++;
				
				switch (getDownGapZone(currentDay, previousDay)){
					case DH:		DH.add(currentDay);
									break;
					case DHO:		DHO.add(currentDay);
									break;
					case DOC:		DOC.add(currentDay);
									break;
					case DCL:		DCL.add(currentDay);
									break;
					case DL:		DL.add(currentDay);
									break;				
					default:		break;
				}
			}
			//PRIOR DAY UP
			else if(previousDay.getOpen() < previousDay.getClose())
			{
				UpDaycounter++;
				
				switch (getUpGapZone(currentDay, previousDay)){
					case UH:		UH.add(currentDay);
									break;
					case UHC:		UHC.add(currentDay);
					break;
					case UCO:		UCO.add(currentDay);
									break;
					case UOL:		UOL.add(currentDay);
									break;
					case UL:		UL.add(currentDay);
									break;
					default:		break;
				}
			}
			else
			{
				NoZONE.add(new DohlcPair(currentDay, previousDay));
			}
			totalCounted++;
			currentDay = previousDay;
		}	
		
		if(NoZONE.size() != 0){
			{throw new NoGapZoneException(NoZONE);}
		}
		
		
		int total = DownDaycounter+UpDaycounter+NoZONE.size();
		System.out.println("DHcounter: "+ DH.size());
		System.out.println("DHOcounter: "+ DHO.size());
		System.out.println("DOCcounter: "+ DOC.size());
		System.out.println("DCLcounter: "+ DCL.size());
		System.out.println("DLcounter: "+ DL.size());
		
		System.out.println("\nUHcounter: "+ UH.size());
		System.out.println("UHCcounter: "+ UHC.size());
		System.out.println("UCOcounter: "+ UCO.size());
		System.out.println("UOLcounter: "+ UOL.size());
		System.out.println("ULcounter: "+ UL.size());
		
		System.out.println("\nDownDaycounter: "+ DownDaycounter);
		System.out.println("UpDaycounter: "+ UpDaycounter);
		System.out.println("NoZONE: "+ NoZONE.size());
		System.out.println("total: "+total);
		
		
		if(total == totalCounted)
			{return true;}
		else
			{return false;}	
	}

	private GapZone getUpGapZone(DOHLC currentDay, DOHLC previousDay) {
		
		if(currentDay.getOpen() > previousDay.getHigh())
		{
			return GapZone.UH;
		}
		else if(currentDay.getOpen() <= previousDay.getHigh() && currentDay.getOpen() > previousDay.getClose())
		{
			return GapZone.UHC;
		}
		else if(currentDay.getOpen() <= previousDay.getClose() && currentDay.getOpen() > previousDay.getOpen())
		{
			return GapZone.UCO;
		}
		else if(currentDay.getOpen() <= previousDay.getOpen() && currentDay.getOpen() > previousDay.getLow())
		{
			return GapZone.UOL;
		}
		else if(currentDay.getOpen() <= previousDay.getLow())
		{
			return GapZone.UL;
		}
		
		return null;
	}

	private GapZone getDownGapZone(DOHLC currentDay, DOHLC previousDay) {
		
		if(currentDay.getOpen() > previousDay.getHigh())
		{
			return GapZone.DH;
		}
		else if(currentDay.getOpen() <= previousDay.getHigh() && currentDay.getOpen() > previousDay.getOpen())
		{
			return GapZone.DHO;
		}
		else if(currentDay.getOpen() <= previousDay.getOpen() && currentDay.getOpen() > previousDay.getClose())
		{
			return GapZone.DOC;
		}
		else if(currentDay.getOpen() <= previousDay.getClose() && currentDay.getOpen() > previousDay.getLow())
		{
			return GapZone.DCL;
		}
		else if(currentDay.getOpen() <= previousDay.getLow())
		{
			return GapZone.DL;
		}
		
		return null;
	}
	
}
