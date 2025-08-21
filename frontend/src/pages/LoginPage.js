import React from "react";
import { useNavigate } from "react-router-dom";

function LoginPage({}) {
  const navigate = useNavigate();

  return (
    <div style={styles.container}>
      <h1>Welcome to Streaming Service</h1>
      <button style={styles.button} onClick={() => navigate("/home")}>
        Login
      </button>
    </div>
  );
}

const styles = {
  container: {
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    justifyContent: "center",
    height: "100vh",
    backgroundColor: "#111",
    color: "white",
  },
  button: {
    padding: "10px 20px",
    fontSize: "16px",
    cursor: "pointer",
    borderRadius: "5px",
    border: "none",
    backgroundColor: "#e50914",
    color: "white",
    marginTop: "20px",
  },
};

export default LoginPage;
