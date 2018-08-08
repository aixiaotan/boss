package org.boss.hong;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@SpringBootApplication
@MapperScan(basePackages = "org.boss.hong.**.mapper")
public class BossHongApplication extends WebMvcConfigurerAdapter{
	
	/**
	 * 修改spring boot 默认的json解析方式。为了避免时间格式化，以及对象的循环引用
	 */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
      super.configureMessageConverters(converters);
      // 初始化转换器
      FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
      // 初始化一个转换器配置
      FastJsonConfig fastJsonConfig = new FastJsonConfig();
      fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect);
      // 将配置设置给转换器并添加到HttpMessageConverter转换器列表中
      fastConvert.setFastJsonConfig(fastJsonConfig);
      converters.add(fastConvert);
    }
    
	public static void main(String[] args) throws Exception {
		SpringApplication.run(BossHongApplication.class, args);
	}

}
