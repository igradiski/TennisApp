import { Modal } from "antd";

export default function errorModal(title: string, content: string) {
  Modal.error({
    title: title,
    content: content,
  });
}
