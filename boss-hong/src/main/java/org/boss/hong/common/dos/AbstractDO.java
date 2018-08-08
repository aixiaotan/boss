package org.boss.hong.common.dos;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


/**
 * 实体DO基类
 * @author peiHongWei
 *
 * 2018年8月8日
 */
public abstract class AbstractDO implements Serializable {


	private static final long serialVersionUID = 535L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
