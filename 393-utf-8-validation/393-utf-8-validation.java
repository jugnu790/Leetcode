class Solution {
  public boolean validUtf8(int[] data) {

   
    int numberOfBytesToProcess = 0;

    
    for (int i = 0; i < data.length; i++) {

     
      String binRep = Integer.toBinaryString(data[i]);
      binRep =binRep.length() >= 8? binRep.substring(binRep.length() - 8):"00000000".substring(binRep.length() % 8) + binRep;
                                  
      
      if (numberOfBytesToProcess == 0) {
        for (int j = 0; j < binRep.length(); j++) {
          if (binRep.charAt(j) == '0') {
            break;
          }

          numberOfBytesToProcess += 1;
        }

        if (numberOfBytesToProcess == 0) {
          continue;
        }
        if (numberOfBytesToProcess > 4 || numberOfBytesToProcess == 1) {
          return false;
        }

      } else {

       
        if (!(binRep.charAt(0) == '1' && binRep.charAt(1) == '0')) {
          return false;
        }
      }
      numberOfBytesToProcess -= 1;
    }
    return numberOfBytesToProcess == 0;
  }
}