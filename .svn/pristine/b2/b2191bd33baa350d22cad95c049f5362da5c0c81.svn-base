package com.pengyue.ipo.util;

import java.util.ArrayList;
import java.util.List;

public class Baike {
	private List<String> curlu;
	private int maxNoping;
	List<PaiBean> inibeans = new ArrayList<PaiBean>();//

	public static void main(String[] args) {
		Baike oBaike = new Baike();
		oBaike.initcur();
		oBaike.xicur();
	}

	/**
	 * 洗
	 */
	public void xicur() {
		int cur = 10;
		if (inibeans.get(0).getDs().equals("0")) {
			cur = 10;
		} else {
			cur = Integer.parseInt(inibeans.get(0).getDs());
		}
		
		for(int i=0;i<=cur;i++){
			inibeans.remove(0);
		}
		 System.out.println(cur+"   "+inibeans.size());
		int qie=(int) (Math.random() * 21) + 10;
		for(int i=0;i<qie;i++){
			inibeans.remove(inibeans.size()-1);
		}
		 System.out.println(qie+"   "+inibeans.size());
	}

	/**
	 * monifp
	 */
	public void initcur() {
		int ps = 8;
		int k = 52 * ps;

		List<paicountbean> initcount1 = new ArrayList<paicountbean>();// h1
		List<paicountbean> initcount2 = new ArrayList<paicountbean>();// h2
		List<paicountbean> initcount3 = new ArrayList<paicountbean>();// h3
		List<paicountbean> initcount4 = new ArrayList<paicountbean>();// h4
		for (int j = 0; j < 13; j++) {
			paicountbean o = new paicountbean();
			o.setCurrentcount(0);
			o.setValue(j + 1 + "");
			o.setYs(1 + "");
			paicountbean o1 = new paicountbean();
			o1.setCurrentcount(0);
			o1.setValue(j + 1 + "");
			o1.setYs(2 + "");
			paicountbean o2 = new paicountbean();
			o2.setCurrentcount(0);
			o2.setValue(j + 1 + "");
			o2.setYs(3 + "");

			paicountbean o3 = new paicountbean();
			o3.setCurrentcount(0);
			o3.setValue(j + 1 + "");
			o3.setYs(4 + "");
			initcount1.add(o);
			initcount2.add(o1);
			initcount3.add(o2);
			initcount4.add(o3);

		}

		int j = 1;
		do {
			int initRan = (int) (Math.random() * 13) + 1;// 大小
			int initRanys = (int) (Math.random() * 4) + 1;// 颜色

			if (initRanys == 1) {

				if (initcount1.get(initRan - 1).getCurrentcount() < ps) {
					// System.out.println(initRanys);
					initcount1.get(initRan - 1).setCurrentcount(
							initcount1.get(initRan - 1).getCurrentcount() + 1);
					PaiBean o = new PaiBean();
					o.setYs(initRanys + "");
					o.setValue(initRan + "");
					if (initRan > 9) {
						o.setDs(0 + "");
					} else {
						o.setDs(initRan + "");
					}
					inibeans.add(o);
					j++;
				}
			}

			if (initRanys == 2) {

				if (initcount2.get(initRan - 1).getCurrentcount() < ps) {
					// System.out.println(initRanys);
					initcount2.get(initRan - 1).setCurrentcount(
							initcount2.get(initRan - 1).getCurrentcount() + 1);
					PaiBean o = new PaiBean();
					o.setYs(initRanys + "");
					o.setValue(initRan + "");
					if (initRan > 9) {
						o.setDs(0 + "");
					} else {
						o.setDs(initRan + "");
					}
					inibeans.add(o);
					j++;
				}
			}

			if (initRanys == 3) {

				if (initcount3.get(initRan - 1).getCurrentcount() < ps) {
					// System.out.println(initRanys);
					initcount3.get(initRan - 1).setCurrentcount(
							initcount3.get(initRan - 1).getCurrentcount() + 1);
					PaiBean o = new PaiBean();
					o.setYs(initRanys + "");
					o.setValue(initRan + "");
					if (initRan > 9) {
						o.setDs(0 + "");
					} else {
						o.setDs(initRan + "");
					}
					inibeans.add(o);
					j++;
				}
			}

			if (initRanys == 4) {

				if (initcount4.get(initRan - 1).getCurrentcount() < ps) {
					// System.out.println(initRanys);
					initcount4.get(initRan - 1).setCurrentcount(
							initcount4.get(initRan - 1).getCurrentcount() + 1);
					PaiBean o = new PaiBean();
					o.setYs(initRanys + "");
					o.setValue(initRan + "");
					if (initRan > 9) {
						o.setDs(0 + "");
					} else {
						o.setDs(initRan + "");
					}
					inibeans.add(o);
					j++;
				}
			}

		} while (j <= k);
		//System.out.println(inibeans.size());
//		for (int c = 0; c < inibeans.size(); c++) {
//			System.out.println(inibeans.get(c).ds);
//		}

	}

	private class paicountbean {
		private String ys;
		private String value;
		private int currentcount = 0;

		public String getYs() {
			return ys;
		}

		public void setYs(String ys) {
			this.ys = ys;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public int getCurrentcount() {
			return currentcount;
		}

		public void setCurrentcount(int currentcount) {
			this.currentcount = currentcount;
		}

	}

	private class PaiBean {
		private String ys;
		private String value;
		private String ds;

		public String getYs() {
			return ys;
		}

		public void setYs(String ys) {
			this.ys = ys;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getDs() {
			return ds;
		}

		public void setDs(String ds) {
			this.ds = ds;
		}

	}
}
