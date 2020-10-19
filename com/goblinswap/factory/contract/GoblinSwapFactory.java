package com.goblinswap.factory.contract;

import io.nuls.contract.sdk.Address;
import io.nuls.contract.sdk.Contract;
import io.nuls.contract.sdk.annotation.JSONSerializable;
import io.nuls.contract.sdk.annotation.View;

import java.util.HashMap;
import java.util.Map;

public class GoblinSwapFactory extends Ownable implements Contract {

    private Map<Address,Address> exchangeMap = new HashMap<Address, Address>();
    private Map<Address,String[]> infoMap = new HashMap<Address, String[]>();


    public void add(Address tokenAddress,Address contractAddress,String symbol,String tokenLogoUrl,Address lpToken,String decimals){
        onlyOwner();
        exchangeMap.put(tokenAddress,contractAddress);
        infoMap.put(tokenAddress,new String[]{contractAddress.toString(),symbol,tokenLogoUrl,lpToken.toString(),decimals});
    }

    public void remove(Address tokenAddress){
        onlyOwner();
        exchangeMap.remove(tokenAddress);
        infoMap.remove(tokenAddress);
    }

    @View
    public Address getExchange(Address tokenAddress){
        return exchangeMap.get(tokenAddress);
    }

    @View
    @JSONSerializable
    public Map<Address, String[]> getInfo(){
        return infoMap;
    }


}
