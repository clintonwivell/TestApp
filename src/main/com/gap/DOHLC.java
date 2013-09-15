package main.com.gap;

import java.util.Date;

public class DOHLC {

	private int DOHLCid;
	private String symbol;
    private Date datestamp;
    private float open;
    private float high;
    private float low;
    private float close;
    private int volume;
    private int openinterest;
    
    public int getDOHLCid() {
		return DOHLCid;
	}
	public void setDOHLCid(int dOHLCid) {
		DOHLCid = dOHLCid;
	}
    public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Date getDatestamp() {
		return datestamp;
	}
	public void setDatestamp(Date datestamp) {
		this.datestamp = datestamp;
	}
	public float getOpen() {
		return open;
	}
	public void setOpen(Float open) {
		this.open = open;
	}
	public float getHigh() {
		return high;
	}
	public void setHigh(Float high) {
		this.high = high;
	}
	public float getLow() {
		return low;
	}
	public void setLow(Float low) {
		this.low = low;
	}
	public float getClose() {
		return close;
	}
	public void setClose(Float close) {
		this.close = close;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public int getOpeninterest() {
		return openinterest;
	}
	public void setOpeninterest(Integer openinterest) {
		this.openinterest = openinterest;
	}
	
	@Override
    public String toString() {
        return symbol + ", " + datestamp.toGMTString() + ", " + open + ", " + high + ", "
                + low + ", " + close + ", "+ volume + ", " + openinterest;
	}
}
