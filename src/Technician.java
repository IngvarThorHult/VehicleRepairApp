import javax.xml.crypto.Data;



public class Technician implements ITechnician {
    @Override
    public double CalculatePay(String repairCostStr, String rateStr) {
        double repairCost = Double.parseDouble(repairCostStr);
        double rate = Double.parseDouble(rateStr);
        return repairCost / rate;

    }


    @Override
    public boolean ValidateData(Dataa dataToValidate) {
        try {
            if (dataToValidate.getLocation().isEmpty()) return false;
            if (dataToValidate.getName().isEmpty()) return false;
            if (Double.parseDouble(dataToValidate.getRepairCost()) <= 0) return false;
            if (Double.parseDouble(dataToValidate.getRate()) <= 0) return false;
        } catch (NumberFormatException e) {
            return false;
        }
        return true;

    }

}




