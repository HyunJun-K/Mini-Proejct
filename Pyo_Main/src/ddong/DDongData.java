package ddong;

import java.io.Serializable;
import java.util.ArrayList;

public class DDongData implements Serializable {

	private static final long serialVersionUID = 1000L;

	public String src, type;

	public String dst;

	public Object data;

	public boolean chk;

	@Override
	public String toString() {
		return "DDongData [src=" + src + ", type=" + type + ", dst=" + dst + ", data=" + data + ", chk=" + chk + "]";
	}

}