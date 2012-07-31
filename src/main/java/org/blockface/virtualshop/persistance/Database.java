package org.blockface.virtualshop.persistance;

import org.blockface.virtualshop.VirtualShop;

import java.sql.ResultSet;

public interface Database
{
    public void Load(VirtualShop plugin) throws Exception;

    public ResultSet Query(String query);

    public void Unload();
}
