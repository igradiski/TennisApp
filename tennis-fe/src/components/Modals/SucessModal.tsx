import { Modal } from "antd";

export default function successModal(title: string, content: string) {
  Modal.success({
    title: title,
    content: content,
  });
}
