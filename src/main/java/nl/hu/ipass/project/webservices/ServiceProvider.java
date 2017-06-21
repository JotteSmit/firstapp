package nl.hu.ipass.project.webservices;

public class ServiceProvider {
	private static EZListService ezlistService = new EZListService();

	public static EZListService getEZListService() {
		return ezlistService;
	}
}