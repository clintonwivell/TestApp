package main.com.gap;

import java.util.Date;

public class DOHLC {

	private int DOHLCid;
	private String symbol;
    private Date datestamp;
    private Float open;
    private Float high;
    private Float low;
    private Float close;
    private Integer volume;
    private Integer openinterest;
    
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
	public Float getOpen() {
		return open;
	}
	public void setOpen(Float open) {
		this.open = open;
	}
	public Float getHigh() {
		return high;
	}
	public void setHigh(Float high) {
		this.high = high;
	}
	public Float getLow() {
		return low;
	}
	public void setLow(Float low) {
		this.low = low;
	}
	public Float getClose() {
		return close;
	}
	public void setClose(Float close) {
		this.close = close;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public Integer getOpeninterest() {
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
