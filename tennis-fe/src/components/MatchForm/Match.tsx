import { Pagination, Select, Table, Cascader, Button } from "antd";
import { FunctionComponent } from "react";
import "../MatchForm/Match.css";
const { Option } = Select;

const Match: FunctionComponent = () => {
  const filter = (inputValue: string, path: any) => {
    return path.some(
      (option: any) =>
        option.label.toLowerCase().indexOf(inputValue.toLowerCase()) > -1
    );
  };

  const tableData = [
    {
      id: "1",
      player: "Ivor gz",
      winner: "1",
      single: "true",
      playTime: "1:30;27",
      date: "15.4.2022.",
      court: "Oroslavje",
    },
    {
      id: "2",
      player: "Ivor gz",
      winner: "1",
      single: "true",
      playTime: "1:30;27",
      date: "15.4.2022.",
      court: "Oroslavje",
    },
  ];

  const columns = [
    {
      title: "Player",
      dataIndex: "player",
    },
    {
      title: "Result",
      dataIndex: "result",
    },
    {
      title: "Winner",
      dataIndex: "winner",
    },
    {
      title: "Single",
      dataIndex: "single",
    },
    {
      title: "Play time",
      dataIndex: "playTime",
    },
    {
      title: "Date",
      dataIndex: "date",
    },
    {
      title: "Court",
      dataIndex: "court",
    },
  ];
  const mockOptions = [
    {
      value: "zhejiang",
      label: "Zhejiang",
    },
  ];
  return (
    <div className="main-container">
      <h1 className="form-title">Matches</h1>
      <div className="tableFilter">
        <div className="filterItem">
          <p className="label">Player:</p>
          <Cascader
            options={mockOptions}
            style={{ width: 120 }}
            //onChange={onChange}
            placeholder="Please select"
            showSearch={{ filter }}
          />
        </div>
        <div className="filterItem">
          <p className="label">Player:</p>
          <Select
            defaultValue="lucy"
            style={{ width: 120 }}
            //onChange={handleChange}
          ></Select>
        </div>
        <div className="filterItem">
          <p className="label">Player:</p>
          <Select
            defaultValue="lucy"
            style={{ width: 120 }}
            //onChange={handleChange}
          ></Select>
        </div>
        <div className="filterItem">
          <p className="label">Player:</p>
          <Select
            defaultValue="lucy"
            style={{ width: 120 }}
            //onChange={handleChange}
          ></Select>
        </div>
        <div className="filterItem">
          <p className="label">Player:</p>
          <Select
            defaultValue="lucy"
            style={{ width: 120 }}
            //onChange={handleChange}
          ></Select>
        </div>
        <div className="filterItem">
          <p className="label">Player:</p>
          <Select
            defaultValue="lucy"
            style={{ width: 120 }}
            //onChange={handleChange}
          ></Select>
        </div>
      </div>

      <Table
        className="tablica-tip-sredstva"
        columns={columns}
        scroll={{ x: 150 }}
        dataSource={tableData}
        pagination={false}
        rowKey="name"
      />
      <Pagination
        pageSize={1}
        total={2}
        //onChange={promijeniStranicu}
      />
      <div className="CRUD_buttons">
        <Button
          type="primary"
          htmlType="submit"
          style={{ width: "120px", marginBottom: "1px" }}
          //onClick={() => userLogin()}
          className="prijava-button"
        >
          Generate stats
        </Button>
        <Button
          type="primary"
          htmlType="submit"
          style={{ width: "120px", marginBottom: "1px" }}
          //onClick={() => userLogin()}
          className="prijava-button"
        >
          Delete Match
        </Button>
        <Button
          type="primary"
          htmlType="submit"
          style={{ width: "120px", marginBottom: "1px" }}
          //onClick={() => userLogin()}
          className="prijava-button"
        >
          New Match
        </Button>
        <Button
          type="primary"
          htmlType="submit"
          style={{ width: "120px", marginBottom: "1px" }}
          //onClick={() => userLogin()}
          className="prijava-button"
        >
          Update Match
        </Button>
      </div>
    </div>
  );
};
export default Match;
