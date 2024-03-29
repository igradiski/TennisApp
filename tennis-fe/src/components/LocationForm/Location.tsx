import { FunctionComponent, useEffect, useState } from "react";
import "antd/dist/antd.css";
import "../LocationForm/LocationCSS.css";
import { Button, Form, Input, Table, Pagination } from "antd";
import ILocations from "../../data/ILocations";
import IDefaultFilter from "../../data/IDefaultFilter";
import { addLocation, getLocationsPaged } from "../../api/locations";
import successModal from "../Modals/SucessModal";
import errorModal from "../Modals/ErrorModal";
import IPaging from "../../data/IPaging";
import { useDispatch, useSelector } from "react-redux";
import {
  fetchAllLocations,
  insertNewLocation,
} from "../../store/slices/locationsSlice";
import { RootState } from "../../store/reducer";
import { addLocationInDB } from "../../store/slices/locationsSlice";
import TableUpdateDelete from "../UpdateDeletePop/TableUpdateDelete";

const Location: FunctionComponent = () => {
  const [name, setName] = useState("");
  const [adress, setAdress] = useState("");
  const [city, setCity] = useState("");
  //table
  const pageSize = 5;
  const [pageNo, setPageNo] = useState(0);
  const [totalItems, setTotalItems] = useState(0);
  const tableData = useSelector(
    (state: RootState) => state.locations.tableData
  );
  const insertedLocation = useSelector(
    (state: RootState) => state.locations.location
  );
  const dispatch = useDispatch();

  const changePageNo = (page: number, pageSize: number | undefined) => {
    setPageNo(page - 1);
  };

  const editClick = (text: any, record: any) => {};

  const deleteClick = (record: any) => {};

  const getInitialData = async () => {
    const data: IPaging = {
      pageNo: pageNo,
      pageSize: pageSize,
      sort: [],
    };
    const filter: IDefaultFilter = {
      dateFrom: "",
      dateUntil: "",
      name: "",
    };
    dispatch(fetchAllLocations({ data: data, filter: filter }));
  };

  useEffect(() => {
    getInitialData();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [pageNo]);

  const columns = [
    {
      title: "Name",
      dataIndex: "name",
    },
    {
      title: "Adress",
      dataIndex: "adress",
    },
    {
      title: "City",
      dataIndex: "city",
    },
    {
      title: "Date",
      dataIndex: "date",
    },
    {
      title: "",
      dataIndex: "name",
      render: (text: any, record: any) =>
        TableUpdateDelete(
          () => editClick(text, record),
          () => deleteClick(record),
          "Do you really want to delete this record?"
        ),
    },
  ];

  const insertLocation = async () => {
    let data: ILocations = {
      adress: adress,
      city: city,
      date: "",
      name: name,
    };
    dispatch(insertNewLocation(data));
    //todo modal
  };
  return (
    <div className="main-container">
      <h1 className="form-title">Locations</h1>
      <Form
        name="LocationForm"
        className="locationForm"
        style={{ paddingTop: "1px" }}
      >
        <Form.Item
          className="input-row"
          label="Name"
          name="name"
          rules={[
            {
              required: true,
              message: "name required",
            },
          ]}
        >
          <Input
            style={{
              background: "#ffd8bf",
              border: "solid 1px #d4380d",
              borderRadius: "10px",
              textAlign: "center",
              fontWeight: "bold",
            }}
            className="input-login-textbox"
            value={name}
            maxLength={50}
            onChange={(e) => setName(e.target.value)}
          />
        </Form.Item>
        <Form.Item
          className="input-row"
          label="Adress"
          name="adress"
          rules={[
            {
              required: true,
              message: "adress required",
            },
          ]}
        >
          <Input
            style={{
              background: "#ffd8bf",
              border: "solid 1px #d4380d",
              borderRadius: "10px",
              textAlign: "center",
              fontWeight: "bold",
            }}
            className="input-login-textbox"
            value={adress}
            maxLength={50}
            onChange={(e) => setAdress(e.target.value)}
          />
        </Form.Item>
        <Form.Item
          className="input-row"
          label="City"
          name="city"
          rules={[
            {
              required: true,
              message: "city required",
            },
          ]}
        >
          <Input
            style={{
              background: "#ffd8bf",
              border: "solid 1px #d4380d",
              borderRadius: "10px",
              textAlign: "center",
              fontWeight: "bold",
            }}
            className="input-login-textbox"
            value={city}
            maxLength={50}
            onChange={(e) => setCity(e.target.value)}
          />
        </Form.Item>
        <Form.Item>
          <Button
            type="primary"
            htmlType="submit"
            onClick={() => insertLocation()}
            className="prijava-button"
          >
            Save
          </Button>
        </Form.Item>
      </Form>
      <Table
        className="tablica-tip-sredstva"
        columns={columns}
        scroll={{ x: 150 }}
        dataSource={tableData}
        pagination={false}
        rowKey="name"
      />
      <Pagination pageSize={1} total={2} onChange={changePageNo} />
    </div>
  );
};

export default Location;
