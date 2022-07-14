import axios from "axios";
import { toast } from "react-toastify";
import icon from "../../assets/img/notification-icon.svg";
import { VITE_BACKEND_URL } from "../../utils/request";

type Props = {
  saleId: number;
};

function handleClick(id: number) {
  axios(`${VITE_BACKEND_URL}/sales/${id}/notification`).then((response) => {
    toast.info("SMS enviado com sucesso");
  });
}

function NotificationButton({ saleId }: Props) {
  return (
    <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)}>
      <img src={icon} alt="Notificar" />
    </div>
  );
}

export default NotificationButton;