package cn.ms.coon.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.ms.coon.Mconf;
import cn.ms.neural.NURL;

import com.alibaba.fastjson.JSON;

public abstract class AbstractMconf implements Mconf {

	private static final Logger logger = LoggerFactory.getLogger(AbstractMconf.class);

	protected NURL url;
	protected String ROOT;

	@Override
	public void connect(NURL url) {
		this.url = url;
		this.ROOT = url.getPath();
	}

	@SuppressWarnings("unchecked")
	protected <T> T json2Obj(String json, Class<T> clazz) {
		try {
			if (clazz == null) {
				return (T) JSON.parseObject(json);
			} else {
				return JSON.parseObject(json, clazz);
			}
		} catch (Exception e) {
			logger.error("Serialization exception", e);
			throw e;
		}
	}

	protected String obj2Json(Object obj) {
		return JSON.toJSONString(obj);
	}
	
	public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

	public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
	
}
