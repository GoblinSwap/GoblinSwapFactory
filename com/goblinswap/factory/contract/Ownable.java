package com.goblinswap.factory.contract;

import io.nuls.contract.sdk.Address;
import io.nuls.contract.sdk.Event;
import io.nuls.contract.sdk.Msg;
import io.nuls.contract.sdk.annotation.Required;
import io.nuls.contract.sdk.annotation.View;

import java.math.BigInteger;

import static io.nuls.contract.sdk.Utils.emit;
import static io.nuls.contract.sdk.Utils.require;

public class Ownable {
    /**
     * 合约创建者
     */
    protected Address contractCreator;

    protected Address owner;

    public Ownable() {
        this.owner = Msg.sender();
        this.contractCreator = this.owner;
    }



    protected void onlyOwner() {
        require(Msg.sender().equals(owner), "Only the owner of the contract can execute it.");
    }



}
