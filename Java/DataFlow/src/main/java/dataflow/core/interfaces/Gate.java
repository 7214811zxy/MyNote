package dataflow.core.interfaces;


/**
 * Jupyter Zhu
 * 2020.11.03
 * Gate表示一个计算流中的门，其中包含了计算逻辑，输入数据的节点信息和输出数据的信息
 * */
public interface Gate {

    /**
     * 获得该门的所有的输入节点信息
     * */
    InputNodes getInputNodes();

    /**
     * 获得该门的输出节点信息
     * */
    OutputNodes getOutputNodes();

    /**
     * 获得该门输出节点与输入节点之间的拓扑关系
     * */
    Topology getTopology();
}
