package io.coon.support.mconf;

import io.coon.Coon;
import io.coon.api.Mconf;
import io.neural.NURL;

import java.util.Map;

public class MconfGovernor {

	Mconf mconf;

	public MconfGovernor(Mconf mconf) {
		this.mconf = mconf;
	}
	
	private Map<String, Map<String, String>> na() {
		return mconf.confs();
	}
	
	public static void main(String[] args) {
		try {
			NURL nurl = NURL.valueOf("zookeeper://127.0.0.1:2181/mconf?session=5000");
			Mconf mconf = Coon.CF.getCoon(nurl, Mconf.class);
			mconf.connect(nurl);
			System.out.println(mconf);
			MconfGovernor governor = new MconfGovernor(mconf);
			System.out.println(governor.na());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}