package store.utils;

public class JdbcUtils {
	
	public static void close(AutoCloseable...autoCloseables) {	// 가변 파라미터: 타입 일치, 개수 변동 시 배열로
																// AutoCloseable: interface
		
		for (AutoCloseable auto : autoCloseables) {
			if (auto == null) {
				continue;
			}
			
			try {
				auto.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
