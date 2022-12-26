package com.example.gymProject.common;

import lombok.Data;

@Data
public class Paging {
	private int listSize = 5;
	private int rangeSize = 10;
	private int page;
	private int range;
	private int listCnt;
	private int pageCnt;
	private int startPage;
	private int startList;
	private int endPage;
	private boolean prev;
	private boolean next;

	public void pageInfo (int page, int range, int listCnt) {
		this.page = page;
		this.range = range;
		this.listCnt = listCnt;

		this.pageCnt = (int)Math.ceil((double)listCnt/listSize);

		this.startPage = (range - 1) * rangeSize + 1;

		this.endPage = range * rangeSize;

		this.startList = (page - 1) * listSize;

		this.prev = range == 1 ? false : true;

		this.next = endPage > pageCnt ? false : true;

		if(this.endPage > this.pageCnt) {
			this.endPage = this.pageCnt;
			this.next = false;
		}
	}
}
