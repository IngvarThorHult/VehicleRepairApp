import javax.xml.crypto.Data;

public interface ITechnician {
    double CalculatePay( String repairCost, String rate);
    boolean ValidateData(Dataa dataToValidate);
}
