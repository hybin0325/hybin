package com.edas.business.dingtalk.entity;

public class DingDingUrlData {
    /**
     *  企业Id
     */
    private String corpid;
    /**
     * secret管理组的凭证密钥
     */
    private String corpsecret;
    /**
     * 获取ToKen的请求
     */
    private String Get_Token_Url;
    /**
     * 发送消息的请求
     */
    private String SendMessage_Url;
    private String Upload_Url;
    public String getCorpid() {
        return corpid;
    }
    public void setCorpid(String corpid) {
        this.corpid = corpid;
    }
    public String getCorpsecret() {
        return corpsecret;
    }
    public void setCorpsecret(String corpsecret) {
        this.corpsecret = corpsecret;
    }
    public void setGet_Token_Url(String corpid,String corpsecret) {
        this.Get_Token_Url ="https://oapi.dingtalk.com/gettoken?appkey="+corpid+"&appsecret="+corpsecret;
    }
    public String getGet_Token_Url() {
        return Get_Token_Url;
    }
    public String getSendMessage_Url(){
        SendMessage_Url = "https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2?access_token=";
        return SendMessage_Url;
    }
    public String getUpload_Url(){
        Upload_Url = "https://oapi.dingtalk.com/media/upload?access_token=";
        return Upload_Url;
    }
    //获取
    public String getSendUser_Url(){
        SendMessage_Url = "https://oapi.dingtalk.com/user/get?access_token=";
        return SendMessage_Url;
    }

}
