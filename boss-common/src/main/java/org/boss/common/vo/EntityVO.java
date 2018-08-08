package org.boss.common.vo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 实体VO基类
 * @author peiHongWei
 *
 * 2018年8月8日
 */
public class EntityVO extends AbstractVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1587591529228255705L;
	
	/**
	 * 主键
	 */
	private Integer id;
	/**
     * 创建时间
     */
	@JSONField (format = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    /**
     * 修改时间
     */
	@JSONField (format = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
