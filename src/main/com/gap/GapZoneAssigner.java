package main.com.gap;

import java.util.Iterator;

public class GapZoneAssigner {

	public boolean assignGapZone() {
		DOHLC currentDay;
		DOHLC previousDay;
		DohlcDAO dao = new DohlcDAO();
		
		int DHcounter = 0;
		int DHOcounter = 0;
		int DOCcounter = 0;
		int DCLcounter = 0;
		int DLcounter = 0;
		int EQUAL_DOWNcounter = 0;
		
		int UHcounter = 0;
		int UHCcounter = 0;
		int UCOcounter = 0;
		int UOLcounter = 0;
		int ULcounter = 0;
		int EQUAL_UPcounter = 0;
		
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
			if(previousDay.getOpen() > previousDay.getClose())
			{
				DownDaycounter++;
				if(currentDay.getOpen() > previousDay.getHigh())
				{
					DHcounter++;
				}
				if(currentDay.getOpen() <= previousDay.getHigh() && currentDay.getOpen() > previousDay.getOpen())
				{
					DHOcounter++;
				}
				if(currentDay.getOpen() <= previousDay.getOpen() && currentDay.getOpen() > previousDay.getClose())
				{
					DOCcounter++;
				}
				if(currentDay.getOpen() <= previousDay.getClose() && currentDay.getOpen() > previousDay.getLow())
				{
					DCLcounter++;
				}
				if(currentDay.getOpen() <= previousDay.getLow())
				{
					DLcounter++;
				}
				if(currentDay.getOpen() == previousDay.getClose())
				{
					EQUAL_DOWNcounter++;
				}
			}
			
			//PRIOR DAY UP
			if(previousDay.getOpen() < previousDay.getClose())
			{
				DownDaycounter++;
				if(currentDay.getOpen() > previousDay.getHigh())
				{
					UHcounter++;
				}
				if(currentDay.getOpen() <= previousDay.getHigh() && currentDay.getOpen() > previousDay.getClose())
				{
					UHCcounter++;
				}
				if(currentDay.getOpen() <= previousDay.getClose() && currentDay.getOpen() > previousDay.getOpen())
				{
					UCOcounter++;
				}
				if(currentDay.getOpen() <= previousDay.getOpen() && currentDay.getOpen() > previousDay.getLow())
				{
					UOLcounter++;
				}
				if(currentDay.getOpen() <= previousDay.getLow())
				{
					ULcounter++;
				}
				if(currentDay.getOpen() == previousDay.getClose())
				{
					EQUAL_UPcounter++;
				}
			}
			
			currentDay = previousDay;
		}	
		
		int totalDownDays = DHcounter+DHOcounter+DOCcounter+DCLcounter+DLcounter+EQUAL_DOWNcounter;
		
		System.out.println("DHcounter: "+ DHcounter);
		System.out.println("DHOcounter: "+ DHOcounter);
		System.out.println("DOCcounter: "+ DOCcounter);
		System.out.println("DCLcounter: "+ DCLcounter);
		System.out.println("DLcounter: "+ DLcounter);
		System.out.println("EQUAL_DOWNcounter: "+ EQUAL_DOWNcounter);
		System.out.println("\nDownDaycounter: "+ DownDaycounter);
		System.out.println("totalDownDays: "+ totalDownDays);
		
		int totalUpDays = UHcounter+UHCcounter+UCOcounter+UOLcounter+ULcounter+EQUAL_UPcounter;
		
		System.out.println("UHcounter: "+ UHcounter);
		System.out.println("UHCcounter: "+ UHCcounter);
		System.out.println("UCOcounter: "+ UCOcounter);
		System.out.println("UOLcounter: "+ UOLcounter);
		System.out.println("ULcounter: "+ ULcounter);
		System.out.println("EQUAL_UPcounter: "+ EQUAL_UPcounter);
		System.out.println("\nUpDaycounter: "+ UpDaycounter);
		System.out.println("totalUpDays: "+ totalUpDays);
		
		System.out.println((totalUpDays+totalDownDays));
		
		if(totalDownDays ==  DownDaycounter && totalUpDays ==  UpDaycounter)
			{return true;}
		else
			{return false;}	
	}
}
