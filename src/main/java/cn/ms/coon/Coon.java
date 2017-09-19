package cn.ms.coon;

import io.neural.NURL;

/**
 * 分布式协调服务
 * 
 * @author lry
 */
public interface Coon {

	NURL getNurl();

	void connect(NURL nurl);

	boolean available();

	void destroy();

}
