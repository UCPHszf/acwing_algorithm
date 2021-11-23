package Math;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Discretization {
    public void discretization(String[]arr){
        List<String>list= Arrays.stream(arr).distinct().collect(Collectors.toList());
    }
}
