package com.edas.business.tripartite.entity.distribution;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

/**
 * <p>
 * Description: 违章实体
 * </p>
 * <p>
 * Date：2019年6月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_distribution_violation")
@Data
@ToString
@ApiModel(description = "违章实体")
public class Violation implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    private String carNumber;

    private Date time;

    private String location;

    private String reason;

    private String count;

    /**
     *  0未处理 1是处理中 2处理完毕
     */
    private Integer status;

    private String department;

    private String degree;

    private String code;

    private String archive;

    private String excutelocation;

    private String excutedepartment;

    private String latefine;

    private String punishmentaccording;

    private String illegalentry;

    private String locationid;

    private String locationName;

    private String poundage;

    /**
     * 0  不可以  1 可以
     */
    private Integer canProcess;

    private String uniqueCode;

    private String canprocessMsg;

    private String blsm;

    private String wflx;

    private String poundage1;

    private String poundage2;

    private Integer fsbl;

    private String fsblje;

    private String priceSource;

    private String difference;

    private Integer canProcessUsOrder;

    private String usPriceFirst;

    /**
     *  0单位车，1私家车
     */
    private Integer privateFlag;

    /**
     * 0否，1是
     */
    private Integer isChoose;

    /**
     * 0否，1是
     */
    private Integer isLock;

    private String lockPoundage;

    /**
     * 0  不可以  1 可以
     */
    private String canProcessLockOrder;
}