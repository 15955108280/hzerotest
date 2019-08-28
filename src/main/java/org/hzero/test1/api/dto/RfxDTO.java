package org.hzero.test1.api.dto;

import org.hzero.test1.domain.entity.Header;
import org.hzero.test1.domain.entity.LineItem;

import java.util.List;

/**
 * description
 *
 * @author YXP 2019/08/27 9:52
 */
public class RfxDTO {
	private Header header;
	private List<LineItem> lineItem;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public List<LineItem> getLineItem() {
		return lineItem;
	}

	public void setLineItem(List<LineItem> lineItem) {
		this.lineItem = lineItem;
	}
}
