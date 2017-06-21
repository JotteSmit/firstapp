package nl.hu.ipass.project.webservices;

import nl.hu.ipass.project.persistence.*;
import java.sql.SQLException;
import java.util.List;

public class EZListService {
	private BoodschappenlijstDAO BoodschappenlijstDAO = new BoodschappenlijstDAO();
	private FavorietenlijstDAO FavorietenlijstDAO = new FavorietenlijstDAO();
	private GeldpotDAO GeldpotDAO = new GeldpotDAO();
	private GroepsnaamDAO GroepsnaamDAO = new GroepsnaamDAO();
	private StudentDAO StudentDAO = new StudentDAO();
	
	public void addBoodschap(Boodschappenlijst bs) throws SQLException {
		BoodschappenlijstDAO.saveBoodschap(bs);
	}
	
	public void addFavoriet(Favorietenlijst fl) throws SQLException {
		FavorietenlijstDAO.saveFavoriet(fl);
	}
	
	public void addGeldpot(Geldpot gp) throws SQLException {
		GeldpotDAO.saveWeekbedrag(gp);
	}
	
	public void addGroepsnaam(Groepsnaam gn) throws SQLException {
		GroepsnaamDAO.saveGroepsnaam(gn);
	}
	
	public void addStudent(Student st) throws SQLException {
		StudentDAO.saveStudent(st);
	}
	
	public Geldpot updateGeldpot(Geldpot gp) throws SQLException {
		return GeldpotDAO.updateWeekbedrag(gp);
	}
	
	public List<Boodschappenlijst> getAlleBoodschappen() throws SQLException {
		return BoodschappenlijstDAO.vindAlleBoodschappen();
	}
	
	public List<Favorietenlijst> getAlleFavorieten() throws SQLException {
		return FavorietenlijstDAO.vindAlleFavorieten();
	}
	
	public List<Geldpot> getWeekbedrag(String groep) throws SQLException {
		return GeldpotDAO.vindWeekbedrag(groep);
	}
	
	public List<Student> getAlleStudenten(String groep) throws SQLException {
		return StudentDAO.vindAlleStudenten(groep);
	}
	
	public boolean deleteBoodschap(Boodschappenlijst bl) throws SQLException {
		return BoodschappenlijstDAO.deleteBoodschap(bl);
	}
	
	public boolean deleteFavoriet(Favorietenlijst fl) throws SQLException {
		return FavorietenlijstDAO.deleteFavoriet(fl);
	}
	
	public Geldpot getWeekbedragByGroup(String gn) throws SQLException {
		return GeldpotDAO.vindWeekbedragBijGroepsnaam(gn);
	}
	
	public List<Favorietenlijst> getFavorietenByGroep(String groep) throws SQLException {
		return FavorietenlijstDAO.vindFavorietenByGroep(groep);
	}
	
	public List<Boodschappenlijst> getBoodschappenByGroep(String groep) throws SQLException {
		return BoodschappenlijstDAO.vindBoodschappenByGroep(groep);
	}
	
	public List<Geldpot> getAlleGeldpotten() throws SQLException {
		return GeldpotDAO.vindGeldpotten();
	}
}
