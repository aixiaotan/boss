package org.boss.user.vo;

import org.boss.common.vo.EntityVO;

/**
 * 用户VO
 * @author peiHongWei
 *
 * 2018年8月8日
 */
public class LoginUserVO extends EntityVO{

    /**
	 * 
	 */
	private static final long serialVersionUID = 5439059976773049068L;

	/**
     * 登陆微信账号
     */
    private String openId;

    /**
     * 微信用户信息
     */
    private String wechatUserInfo;

    /**
     * 登录手机号
     */
    private String loginPhoneNumber;

    /**
     * 登陆微信账号
     * @return open_id 登陆微信账号
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 登陆微信账号
     * @param openId 登陆微信账号
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * 微信用户信息
     * @return wechat_user_info 微信用户信息
     */
    public String getWechatUserInfo() {
        return wechatUserInfo;
    }

    /**
     * 微信用户信息
     * @param wechatUserInfo 微信用户信息
     */
    public void setWechatUserInfo(String wechatUserInfo) {
        this.wechatUserInfo = wechatUserInfo == null ? null : wechatUserInfo.trim();
    }

    /**
     * 登录手机号
     * @return login_phone_number 登录手机号
     */
    public String getLoginPhoneNumber() {
        return loginPhoneNumber;
    }

    /**
     * 登录手机号
     * @param loginPhoneNumber 登录手机号
     */
    public void setLoginPhoneNumber(String loginPhoneNumber) {
        this.loginPhoneNumber = loginPhoneNumber == null ? null : loginPhoneNumber.trim();
    }
}