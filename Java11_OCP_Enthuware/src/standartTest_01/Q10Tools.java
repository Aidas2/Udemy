package standartTest_01;


//Which line(s) in the following code will fail compilation?
/*
interface Tool{    //1
    void operate(); //2
}

abstract class PowerTool implements Tool{ } //3

class PowerSaw implements PowerTool{  //4   A class cannot "implement" another class. It can only "extend" another class.
                                            // Thus, PowerSaw cannot "implement" PowerTool because PowerTool is a class.
                                            // PowerSaw can "extend" PowerTool.  On the other hand, an interface cannot
                                            // "implement" another interface. It can "extend" another interface.
    @Override //5
    public void operate(){ }
}

class SteamPowerSaw extends PowerSaw{ //6
    @Override //7   The operate(int pressure) method does not override any method from the super class or interface.
                    // Therefore, @Override is invalid here.
    public void operate(int pressure){ }
}

 */