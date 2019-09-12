
public class MessageService {
	public String getMessage() {
		return "Hello World!"; // Hello 1
	}

	public String mockMethod(String strValue) {
		return strValue;
	}

	public static void main(String[] args) {
		System.out.println(new MessageService().getMessage());
	}

	public int Add(String strValues) { 
		int nTotal = 0;
		String strArr[] = null;
		try {
			if (strValues != null && strValues.length() > 0) {
				strArr = strValues.split(",");
				for (String strNum : strArr) {
					if (isNumeric(strNum)) {
						nTotal += Integer.parseInt(strNum);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nTotal;
	}

	private boolean isNumeric(String strNum) {
		try {
			int nValue = Integer.parseInt(strNum);
		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
		return true;
	}

}
