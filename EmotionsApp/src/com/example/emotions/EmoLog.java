package com.example.emotions;

public class EmoLog {
	public int day;
	public int Interval;
	public int mom[];
	public int sf[];
	public int st[];
	public String dati;
	public EmoLog(int day, int interval)
	{
		this.day = day;
		this.Interval = interval;
		
		mom = new int[6];
		sf = new int[9];
		st = new int[3];
		
	}
}
