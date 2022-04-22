import { FunctionComponent, useEffect, useState } from "react";
import "antd/dist/antd.css";
import "../CourtForm/CourtCSS.css";
import { useDispatch, useSelector } from "react-redux";
import TableUpdateDelete from "../UpdateDeletePop/TableUpdateDelete";
import { Button, Cascader, Checkbox, Form, Input } from "antd";
import { RootState } from "../../store/reducer";
import { fetchAllLocationsForCascader } from "../../store/slices/locationsSlice";
import ICourts from "../../data/ICourts";
import { insertNewCourt } from "../../store/slices/courtSlice";
import successModal from "../Modals/SucessModal";
import errorModal from "../Modals/ErrorModal";

const Court: FunctionComponent = () => {
  const [name, setName] = useState("");
  const [type, setType] = useState("");
  const [location, setLocation] = useState("");
  const [hasLights, setHasLights] = useState(false);
  const [isCovered, setIsCovered] = useState(false);

  const insertedCourt = useSelector(
    (state: RootState) => state.courts.insertedCourt
  );
  //cascaders
  const locations = useSelector(
    (state: RootState) => state.locations.locationCascader
  );
  //table
  const pageSize = 5;
  const [pageNo, setPageNo] = useState(0);
  const [totalItems, setTotalItems] = useState(0);

  const dispatch = useDispatch();

  const changePageNo = (page: number, pageSize: number | undefined) => {
    setPageNo(page - 1);
  };

  const editClick = (text: any, record: any) => {};

  const deleteClick = (record: any) => {};

  const getInitialData = async () => {
    var status = dispatch(fetchAllLocationsForCascader());
    console.log(status);
  };

  const insertCourt = async () => {
    let data: ICourts = {
      hasLights: hasLights,
      covered: isCovered,
      location: location,
      name: name,
      type: type,
    };
    try {
      dispatch(insertNewCourt(data));
    } catch (error) {
      console.log(error);
    }
    //todo modal
  };

  useEffect(() => {
    getInitialData();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [pageNo]);

  const courtTypes = [
    {
      label: "Clay",
      value: "CLAY",
    },
    {
      label: "Hard",
      value: "HARD",
    },
    {
      label: "Grass",
      value: "GRASS",
    },
    {
      label: "Artificial grass",
      value: "ARTIFICIAL_GRASS",
    },
  ];

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

  return (
    <div className="main-container">
      <h1 className="form-title">Courts</h1>
      <Form
        name="CourtForm"
        //className="locationForm"
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
          label="Court type"
          name="court"
          rules={[
            {
              required: true,
              message: "court required",
            },
          ]}
        >
          <Cascader
            placeholder="Choose type"
            options={courtTypes}
            placement="bottomRight"
            style={{ fontWeight: "bold" }}
            onChange={(e) => {
              setType(e[0].toString());
            }}
          />
        </Form.Item>
        <Form.Item
          className="input-row"
          label="Location"
          name="location"
          rules={[
            {
              required: true,
              message: "Location required",
            },
          ]}
        >
          <Cascader
            placeholder="Choose location"
            options={locations}
            placement="bottomRight"
            onChange={(e) => {
              setLocation(e[0].toString());
            }}
          />
        </Form.Item>
        <Checkbox
          className="cascader"
          onChange={(e) => setHasLights(e.target.checked)}
        >
          Court has lights?
        </Checkbox>
        <Checkbox
          className="cascader"
          onChange={(e) => setIsCovered(e.target.checked)}
        >
          Court is covered?
        </Checkbox>
        <Form.Item style={{ paddingTop: "1%" }}>
          <Button
            type="primary"
            htmlType="submit"
            onClick={() => insertCourt()}
            className="prijava-button"
          >
            Save
          </Button>
        </Form.Item>
      </Form>
    </div>
  );
};

export default Court;
