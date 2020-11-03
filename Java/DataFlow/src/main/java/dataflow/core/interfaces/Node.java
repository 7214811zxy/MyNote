package dataflow.core.interfaces;

public interface Node {

    /**
     * 设定Node的数据来源为Gate
     *
     * Params:
     *  gateId: 门的唯一索引
     *  outNodeName: 门输出的Node的Name
     *  DBConnect: 数据库连接对象
     *
     * Return:
     *  返回设定来源是否成功
     *
     * PS：对于离线计算而言，目前Node中的数据应该来源于某个Gate或者DB
     * */
    Boolean setFrom(String gateId, String outNodeName);
    Boolean setFrom(DBConnect connect);

    /**
     * 获得node的来源对象
     * Return Origin
     * */
    Origin getFrom();

    /**
     * 设定node的目的地
     * 传入Gate的id，设定node的去向
     * */
    Destination setGoto(String gateId);
    Destination setGoto(DBConnect connect);

    /**
     * 获得当前node的值和值的数据类型
     * */
    NodeValue getValue();
}
