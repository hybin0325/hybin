package com.edas.edasusers.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "shopwwi_rylist")
public class ShopwwiRylist {
	@Id
    private Integer id;
    private String userid;
    private String ryxm;

    private String ryfl;

    private String password;

    private String yxzt;

    private String rywz;

    private String dldqx;

    private String xtfl;

    private String isadmin;

    private String fzroleid;

    private String glfw;

    private String zdbmlistid;

    private String fzrole;

    private String zdbmlist;

    private String bmbh;

    private String xb;

    private Date csrq;

    private String email;

    private String lxfs;

    private String address;

    private Integer userlx;

    private String emailuser;

    private String emailpass;

    private String parentid;

    private Date djrq;

    private Date sxrq;

    private Integer mobuserlx;

    private String mobmac;

    private String ryqx;

    private String openid;

    /**
     * 分享手机
     */
    private String sharetel;

    /**
     * 分享详细
     */
    private String shareinfo;

    /**
     * avatarUrl
     */
    private String avatar;

    /**
     * share store
     */
    private String sharestore;

    /**
     * 公司
     */
    private String clique;

    /**
     * 是否超级管理员
     */
    private String issuper;

    /**
     * 手机
     */
    private String phone;

    /**
     * 电话
     */
    private String landline;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * 个人简介
     */
    private String intro;

    /**
     * 二维码
     */
    private String erweima;

    /**
     * 点赞数
     */
    @Column(name = "like_num")
    private Integer likeNum;

    /**
     * 浏览数
     */
    @Column(name = "browse_num")
    private Integer browseNum;

    /**
     * 我的video
     */
    @Column(name = "info_video")
    private String infoVideo;

    /**
     * 我的标签
     */
    @Column(name = "info_labels")
    private String infoLabels;

    /**
     * 岗位编号
     */
    private String rsaa14;

    /**
     * 岗位名称
     */
    private String rsab02;

    /**
     * 个人介绍视频地址
     */
    @Column(name = "video_src")
    private String videoSrc;

    /**
     * 个人介绍  视频封面
     */
    @Column(name = "video_cover")
    private String videoCover;

    private String poster;

    /**
     * plugid/在企业微信管理后台配置的唯一插件ID
     */
    private String plugid;

    @Column(name = "default_card")
    private Boolean defaultCard;

    /**
     * 我的说明图片
     */
    @Column(name = "info_descpic")
    private String infoDescpic;

    /**
     * 我的签名
     */
    @Column(name = "info_sign")
    private String infoSign;

    /**
     * 名片编辑
     */
    @Column(name = "business_card")
    private String businessCard;

    /**
     * @return userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return ryxm
     */
    public String getRyxm() {
        return ryxm;
    }

    /**
     * @param ryxm
     */
    public void setRyxm(String ryxm) {
        this.ryxm = ryxm == null ? null : ryxm.trim();
    }

    /**
     * @return ryfl
     */
    public String getRyfl() {
        return ryfl;
    }

    /**
     * @param ryfl
     */
    public void setRyfl(String ryfl) {
        this.ryfl = ryfl == null ? null : ryfl.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return yxzt
     */
    public String getYxzt() {
        return yxzt;
    }

    /**
     * @param yxzt
     */
    public void setYxzt(String yxzt) {
        this.yxzt = yxzt == null ? null : yxzt.trim();
    }

    /**
     * @return rywz
     */
    public String getRywz() {
        return rywz;
    }

    /**
     * @param rywz
     */
    public void setRywz(String rywz) {
        this.rywz = rywz == null ? null : rywz.trim();
    }

    /**
     * @return dldqx
     */
    public String getDldqx() {
        return dldqx;
    }

    /**
     * @param dldqx
     */
    public void setDldqx(String dldqx) {
        this.dldqx = dldqx == null ? null : dldqx.trim();
    }

    /**
     * @return xtfl
     */
    public String getXtfl() {
        return xtfl;
    }

    /**
     * @param xtfl
     */
    public void setXtfl(String xtfl) {
        this.xtfl = xtfl == null ? null : xtfl.trim();
    }

    /**
     * @return isadmin
     */
    public String getIsadmin() {
        return isadmin;
    }

    /**
     * @param isadmin
     */
    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin == null ? null : isadmin.trim();
    }

    /**
     * @return fzroleid
     */
    public String getFzroleid() {
        return fzroleid;
    }

    /**
     * @param fzroleid
     */
    public void setFzroleid(String fzroleid) {
        this.fzroleid = fzroleid == null ? null : fzroleid.trim();
    }

    /**
     * @return glfw
     */
    public String getGlfw() {
        return glfw;
    }

    /**
     * @param glfw
     */
    public void setGlfw(String glfw) {
        this.glfw = glfw == null ? null : glfw.trim();
    }

    /**
     * @return zdbmlistid
     */
    public String getZdbmlistid() {
        return zdbmlistid;
    }

    /**
     * @param zdbmlistid
     */
    public void setZdbmlistid(String zdbmlistid) {
        this.zdbmlistid = zdbmlistid == null ? null : zdbmlistid.trim();
    }

    /**
     * @return fzrole
     */
    public String getFzrole() {
        return fzrole;
    }

    /**
     * @param fzrole
     */
    public void setFzrole(String fzrole) {
        this.fzrole = fzrole == null ? null : fzrole.trim();
    }

    /**
     * @return zdbmlist
     */
    public String getZdbmlist() {
        return zdbmlist;
    }

    /**
     * @param zdbmlist
     */
    public void setZdbmlist(String zdbmlist) {
        this.zdbmlist = zdbmlist == null ? null : zdbmlist.trim();
    }

    /**
     * @return bmbh
     */
    public String getBmbh() {
        return bmbh;
    }

    /**
     * @param bmbh
     */
    public void setBmbh(String bmbh) {
        this.bmbh = bmbh == null ? null : bmbh.trim();
    }

    /**
     * @return xb
     */
    public String getXb() {
        return xb;
    }

    /**
     * @param xb
     */
    public void setXb(String xb) {
        this.xb = xb == null ? null : xb.trim();
    }

    /**
     * @return csrq
     */
    public Date getCsrq() {
        return csrq;
    }

    /**
     * @param csrq
     */
    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return lxfs
     */
    public String getLxfs() {
        return lxfs;
    }

    /**
     * @param lxfs
     */
    public void setLxfs(String lxfs) {
        this.lxfs = lxfs == null ? null : lxfs.trim();
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return userlx
     */
    public Integer getUserlx() {
        return userlx;
    }

    /**
     * @param userlx
     */
    public void setUserlx(Integer userlx) {
        this.userlx = userlx;
    }

    /**
     * @return emailuser
     */
    public String getEmailuser() {
        return emailuser;
    }

    /**
     * @param emailuser
     */
    public void setEmailuser(String emailuser) {
        this.emailuser = emailuser == null ? null : emailuser.trim();
    }

    /**
     * @return emailpass
     */
    public String getEmailpass() {
        return emailpass;
    }

    /**
     * @param emailpass
     */
    public void setEmailpass(String emailpass) {
        this.emailpass = emailpass == null ? null : emailpass.trim();
    }

    /**
     * @return parentid
     */
    public String getParentid() {
        return parentid;
    }

    /**
     * @param parentid
     */
    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    /**
     * @return djrq
     */
    public Date getDjrq() {
        return djrq;
    }

    /**
     * @param djrq
     */
    public void setDjrq(Date djrq) {
        this.djrq = djrq;
    }

    /**
     * @return sxrq
     */
    public Date getSxrq() {
        return sxrq;
    }

    /**
     * @param sxrq
     */
    public void setSxrq(Date sxrq) {
        this.sxrq = sxrq;
    }

    /**
     * @return mobuserlx
     */
    public Integer getMobuserlx() {
        return mobuserlx;
    }

    /**
     * @param mobuserlx
     */
    public void setMobuserlx(Integer mobuserlx) {
        this.mobuserlx = mobuserlx;
    }

    /**
     * @return mobmac
     */
    public String getMobmac() {
        return mobmac;
    }

    /**
     * @param mobmac
     */
    public void setMobmac(String mobmac) {
        this.mobmac = mobmac == null ? null : mobmac.trim();
    }

    /**
     * @return ryqx
     */
    public String getRyqx() {
        return ryqx;
    }

    /**
     * @param ryqx
     */
    public void setRyqx(String ryqx) {
        this.ryqx = ryqx == null ? null : ryqx.trim();
    }

    /**
     * @return openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * @param openid
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * 获取分享手机
     *
     * @return sharetel - 分享手机
     */
    public String getSharetel() {
        return sharetel;
    }

    /**
     * 设置分享手机
     *
     * @param sharetel 分享手机
     */
    public void setSharetel(String sharetel) {
        this.sharetel = sharetel == null ? null : sharetel.trim();
    }

    /**
     * 获取分享详细
     *
     * @return shareinfo - 分享详细
     */
    public String getShareinfo() {
        return shareinfo;
    }

    /**
     * 设置分享详细
     *
     * @param shareinfo 分享详细
     */
    public void setShareinfo(String shareinfo) {
        this.shareinfo = shareinfo == null ? null : shareinfo.trim();
    }

    /**
     * 获取avatarUrl
     *
     * @return avatar - avatarUrl
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置avatarUrl
     *
     * @param avatar avatarUrl
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * 获取share store
     *
     * @return sharestore - share store
     */
    public String getSharestore() {
        return sharestore;
    }

    /**
     * 设置share store
     *
     * @param sharestore share store
     */
    public void setSharestore(String sharestore) {
        this.sharestore = sharestore == null ? null : sharestore.trim();
    }

    /**
     * 获取公司
     *
     * @return clique - 公司
     */
    public String getClique() {
        return clique;
    }

    /**
     * 设置公司
     *
     * @param clique 公司
     */
    public void setClique(String clique) {
        this.clique = clique == null ? null : clique.trim();
    }

    /**
     * 获取是否超级管理员
     *
     * @return issuper - 是否超级管理员
     */
    public String getIssuper() {
        return issuper;
    }

    /**
     * 设置是否超级管理员
     *
     * @param issuper 是否超级管理员
     */
    public void setIssuper(String issuper) {
        this.issuper = issuper == null ? null : issuper.trim();
    }

    /**
     * 获取手机
     *
     * @return phone - 手机
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机
     *
     * @param phone 手机
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取电话
     *
     * @return landline - 电话
     */
    public String getLandline() {
        return landline;
    }

    /**
     * 设置电话
     *
     * @param landline 电话
     */
    public void setLandline(String landline) {
        this.landline = landline == null ? null : landline.trim();
    }

    /**
     * 获取微信号
     *
     * @return wechat - 微信号
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * 设置微信号
     *
     * @param wechat 微信号
     */
    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    /**
     * 获取个人简介
     *
     * @return intro - 个人简介
     */
    public String getIntro() {
        return intro;
    }

    /**
     * 设置个人简介
     *
     * @param intro 个人简介
     */
    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    /**
     * 获取二维码
     *
     * @return erweima - 二维码
     */
    public String getErweima() {
        return erweima;
    }

    /**
     * 设置二维码
     *
     * @param erweima 二维码
     */
    public void setErweima(String erweima) {
        this.erweima = erweima == null ? null : erweima.trim();
    }

    /**
     * 获取点赞数
     *
     * @return like_num - 点赞数
     */
    public Integer getLikeNum() {
        return likeNum;
    }

    /**
     * 设置点赞数
     *
     * @param likeNum 点赞数
     */
    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    /**
     * 获取浏览数
     *
     * @return browse_num - 浏览数
     */
    public Integer getBrowseNum() {
        return browseNum;
    }

    /**
     * 设置浏览数
     *
     * @param browseNum 浏览数
     */
    public void setBrowseNum(Integer browseNum) {
        this.browseNum = browseNum;
    }

    /**
     * 获取我的video
     *
     * @return info_video - 我的video
     */
    public String getInfoVideo() {
        return infoVideo;
    }

    /**
     * 设置我的video
     *
     * @param infoVideo 我的video
     */
    public void setInfoVideo(String infoVideo) {
        this.infoVideo = infoVideo == null ? null : infoVideo.trim();
    }

    /**
     * 获取我的标签
     *
     * @return info_labels - 我的标签
     */
    public String getInfoLabels() {
        return infoLabels;
    }

    /**
     * 设置我的标签
     *
     * @param infoLabels 我的标签
     */
    public void setInfoLabels(String infoLabels) {
        this.infoLabels = infoLabels == null ? null : infoLabels.trim();
    }

    /**
     * 获取岗位编号
     *
     * @return rsaa14 - 岗位编号
     */
    public String getRsaa14() {
        return rsaa14;
    }

    /**
     * 设置岗位编号
     *
     * @param rsaa14 岗位编号
     */
    public void setRsaa14(String rsaa14) {
        this.rsaa14 = rsaa14 == null ? null : rsaa14.trim();
    }

    /**
     * 获取岗位名称
     *
     * @return rsab02 - 岗位名称
     */
    public String getRsab02() {
        return rsab02;
    }

    /**
     * 设置岗位名称
     *
     * @param rsab02 岗位名称
     */
    public void setRsab02(String rsab02) {
        this.rsab02 = rsab02 == null ? null : rsab02.trim();
    }

    /**
     * 获取个人介绍视频地址
     *
     * @return video_src - 个人介绍视频地址
     */
    public String getVideoSrc() {
        return videoSrc;
    }

    /**
     * 设置个人介绍视频地址
     *
     * @param videoSrc 个人介绍视频地址
     */
    public void setVideoSrc(String videoSrc) {
        this.videoSrc = videoSrc == null ? null : videoSrc.trim();
    }

    /**
     * 获取个人介绍  视频封面
     *
     * @return video_cover - 个人介绍  视频封面
     */
    public String getVideoCover() {
        return videoCover;
    }

    /**
     * 设置个人介绍  视频封面
     *
     * @param videoCover 个人介绍  视频封面
     */
    public void setVideoCover(String videoCover) {
        this.videoCover = videoCover == null ? null : videoCover.trim();
    }

    /**
     * @return poster
     */
    public String getPoster() {
        return poster;
    }

    /**
     * @param poster
     */
    public void setPoster(String poster) {
        this.poster = poster == null ? null : poster.trim();
    }

    /**
     * 获取plugid/在企业微信管理后台配置的唯一插件ID
     *
     * @return plugid - plugid/在企业微信管理后台配置的唯一插件ID
     */
    public String getPlugid() {
        return plugid;
    }

    /**
     * 设置plugid/在企业微信管理后台配置的唯一插件ID
     *
     * @param plugid plugid/在企业微信管理后台配置的唯一插件ID
     */
    public void setPlugid(String plugid) {
        this.plugid = plugid == null ? null : plugid.trim();
    }

    /**
     * @return default_card
     */
    public Boolean getDefaultCard() {
        return defaultCard;
    }

    /**
     * @param defaultCard
     */
    public void setDefaultCard(Boolean defaultCard) {
        this.defaultCard = defaultCard;
    }

    /**
     * 获取我的说明图片
     *
     * @return info_descpic - 我的说明图片
     */
    public String getInfoDescpic() {
        return infoDescpic;
    }

    /**
     * 设置我的说明图片
     *
     * @param infoDescpic 我的说明图片
     */
    public void setInfoDescpic(String infoDescpic) {
        this.infoDescpic = infoDescpic == null ? null : infoDescpic.trim();
    }

    /**
     * 获取我的签名
     *
     * @return info_sign - 我的签名
     */
    public String getInfoSign() {
        return infoSign;
    }

    /**
     * 设置我的签名
     *
     * @param infoSign 我的签名
     */
    public void setInfoSign(String infoSign) {
        this.infoSign = infoSign == null ? null : infoSign.trim();
    }

    /**
     * 获取名片编辑
     *
     * @return business_card - 名片编辑
     */
    public String getBusinessCard() {
        return businessCard;
    }

    /**
     * 设置名片编辑
     *
     * @param businessCard 名片编辑
     */
    public void setBusinessCard(String businessCard) {
        this.businessCard = businessCard == null ? null : businessCard.trim();
    }
}
