/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.mapper;

import cn.liuyiyou.yishop.entity.SystemParameter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * @author yaofang
 * @version $Id: SystemParameterMapper.java, v 0.1 2014年9月23日 下午5:46:12 yaofang Exp $
 */
public interface SystemParameterMapper extends BaseMapper {

    public List<SystemParameter> queryByParamTypeAndStatus(@Param("paramType") String paramType, @Param("status") String status);

    public SystemParameter queryByParamTypeAndParamKey(@Param("paramType") String paramType, @Param("paramKey") String paramKey);

    public List<SystemParameter> queryByParamTypeForPage(@Param("paramType") String paramType, @Param("begin") int begin, @Param("end") int end);

    public int countByParamType(String paramType);

}
